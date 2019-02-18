package com.sys.model;

public class Attachments {
    private Integer id;

    private Integer source;

    private Integer sourceId;

    private String attachment;
    
    
    
    
    
    public Attachments(Integer source, Integer sourceId) {
		super();
		this.source = source;
		this.sourceId = sourceId;
	}

	public Attachments(Integer source, Integer sourceId, String attachment) {
		super();
		this.source = source;
		this.sourceId = sourceId;
		this.attachment = attachment;
	}

	public Attachments(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }
}