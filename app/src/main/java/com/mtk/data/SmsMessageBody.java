package com.mtk.data;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

/**
 * 短信消息体封装实体
 */
public class SmsMessageBody extends MessageBody {
    private String mNumber;

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        this.mNumber = number;
    }

    @Override
    public void genXmlBuff(XmlSerializer serializer) throws IllegalArgumentException,
            IllegalStateException, IOException {
        serializer.startTag(null, MessageObj.BODY);
        // event_type
        if (this.getSender() != null) {
            serializer.startTag(null, MessageObj.SENDER);
            serializer.text(this.getSender());
            serializer.endTag(null, MessageObj.SENDER);
        }
        // mime_type
        if (this.getNumber() != null) {
            serializer.startTag(null, MessageObj.NUMBER);
            serializer.text(this.getNumber());
            serializer.endTag(null, MessageObj.NUMBER);
        }
        // data
        if (this.getContent() != null) {
            serializer.startTag(null, MessageObj.CONTENT);
            serializer.text(this.getContent());
            serializer.endTag(null, MessageObj.CONTENT);
        }
        if (this.getTimestamp() != 0) {
            serializer.startTag(null, MessageObj.TIEMSTAMP);
            serializer.text(String.valueOf(this.getTimestamp()));
            serializer.endTag(null, MessageObj.TIEMSTAMP);
        }
        serializer.endTag(null, MessageObj.BODY);
    }

    @Override
    public String toString() {
        final String separator = ", ";

        StringBuilder str = new StringBuilder();
        str.append("[");

        if (this.getSender() != null) {
            str.append(this.getSender());
        }

        str.append(separator);
        if (this.getNumber() != null) {
            str.append(this.getNumber());
        }

        str.append(separator);
        if (this.getContent() != null) {
            str.append(this.getContent());
        }

        str.append(separator);
        if (this.getTimestamp() != 0) {
            str.append(String.valueOf(this.getTimestamp()));
        }

        str.append("]");
        return str.toString();
    }
}
