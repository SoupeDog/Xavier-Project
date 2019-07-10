package org.xavier.common.logging;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.pattern.*;

import java.util.List;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.21
 * @since Jdk 1.8
 */
@Plugin(name = "escapeJMsg", category = PatternConverter.CATEGORY)
@ConverterKeys({ "escapeJMsg"})
public class HyggeLoggerPattenConverter extends LogEventPatternConverter {
    private final List<PatternFormatter> formatters;

    public HyggeLoggerPattenConverter(List<PatternFormatter> formatters){
        super("escapeJMsg", "escapeJMsg");
        this.formatters = formatters;
    }

    public static HyggeLoggerPattenConverter newInstance(Configuration config, String[] options) {
        if (options.length < 1) {
            LOGGER.error("Incorrect number of options on style. "
                    + "Expected at least 1, received {}", options.length);
            return null;
        }
        if (options[0] == null) {
            LOGGER.error("No pattern supplied on style");
            return null;
        }
        PatternParser parser = PatternLayout.createPatternParser(config);
        List<PatternFormatter> formatters = parser.parse(options[0]);

        return new HyggeLoggerPattenConverter(formatters);
    }

    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
        StringBuilder buf = new StringBuilder();
        for (PatternFormatter formatter : this.formatters) {
            formatter.format(event, buf);
        }
        if(buf.length() > 0){
            toAppendTo.append(StringEscapeUtils.escapeJava(buf.toString()));
        }
    }
}