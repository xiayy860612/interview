package com.s2u2m.interview.ctm.service.proposal;

import com.s2u2m.interview.ctm.config.ConstantConfig;
import com.s2u2m.interview.ctm.entity.Proposal;
import com.s2u2m.interview.ctm.enums.DurationUnitEnum;
import com.s2u2m.interview.ctm.enums.DurationUnitHandler;
import com.s2u2m.interview.ctm.exception.CmtErrorCodeEnum;
import com.s2u2m.interview.ctm.exception.ExceptionBuilder;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class ProposalReaderService,
 * read proposal input files and convert to proposal object
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public class ProposalReaderService {

    private static final String reg = "^(?<title>.+)\\s+(?<duration>\\d*)\\s*(?<unit>lightning|min)$";

    public List<Proposal> read(String filePath) {
        List<Proposal> proposals = new LinkedList<>();
        int lineIndex = 0;

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);

            ++lineIndex;
            String line = reader.readLine();
            while(line != null) {
                if (line.isEmpty()) {
                    ++lineIndex;
                    line = reader.readLine();
                    continue;
                }

                Proposal proposal = this.convert(line);
                proposals.add(proposal);

                ++lineIndex;
                line = reader.readLine();
            }

        } catch (FileNotFoundException ex) {
            throw ExceptionBuilder.build(CmtErrorCodeEnum.ProposalInputFileNotExisted,
                    String.format("proposal file[%s] not existed", filePath));
        } catch (IOException ex) {
            throw ExceptionBuilder.build(CmtErrorCodeEnum.ProposalReadLineError,
                    String.format("read %d line raise unknown error", lineIndex));
        }

        return proposals;
    }

    public Proposal convert(String line) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(line);
        if (!matcher.matches()) {
            throw ExceptionBuilder.build(CmtErrorCodeEnum.ProposalLineFormatError,
                    String.format("line[%s] format error", line));
        }

        String title = matcher.group("title");
        String unit = matcher.group("unit");
        DurationUnitEnum unitEnum = DurationUnitHandler.convert(unit);
        int duration = 0;
        switch (unitEnum) {
            case Lightning:
                duration = ConstantConfig.DurationUnitLightning;
                break;
            case Min:
                String ds = matcher.group("duration");
                duration = Integer.parseInt(ds);
                break;

            default:
                throw ExceptionBuilder.build(CmtErrorCodeEnum.ProposalUnitUnKnown,
                        String.format("unknown unit[%s]", unitEnum));
        }

        return new Proposal(title, duration);
    }
}
