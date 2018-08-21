package org.javacream.training.apache.camel.complexfile;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.javacream.training.util.TextTransformer;

public class ContentProcessor implements Processor {

	private TextTransformer transformer;

	public void setTransformer(TextTransformer transformer) {
		this.transformer = transformer;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		String input = in.getBody(String.class);
		in.setBody(transformer.transform(input));

	}

}