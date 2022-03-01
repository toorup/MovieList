package com.icecool.mymovielist;

public class info {


	private String Vod_img;  //图片路径
	private String Vod_name; //电影名称
	private String Vod_id;  //电影ID
	private String Vod_score;  //电影ID
	private String Vod_update;  //电影ID
	private String Vod_actor;  //电影ID
    

   
    
	public info() {
		super();
	}


	public info(String Vod_img, String Vod_name, String Vod_id, String Vod_score, String Vod_update, String Vod_actor) {
		super();
		this.Vod_img = Vod_img;
        this.Vod_name = Vod_name;
        this.Vod_id= Vod_id;
        this.Vod_score = Vod_score;
        this.Vod_update = Vod_update;
        this.Vod_actor = Vod_actor;
	}


	public String getVod_img() {
		return Vod_img;
	}


	public void setVod_img(String Vod_img) {
		this.Vod_img = Vod_img;
	}
	
	
	
	public String getVod_score() {
		return Vod_score;
	}


	public void setVod_score(String Vod_score) {
		this.Vod_score = Vod_score;
	}
	
	public String getVod_update() {
		return Vod_update;
	}


	public void setVod_update(String Vod_update) {
		this.Vod_update = Vod_update;
	}
	
	public String getVod_actor() {
		return Vod_actor;
	}


	public void setVod_actor(String Vod_actor) {
		this.Vod_actor = Vod_actor;
	}


	public String getVod_name() {
		return Vod_name;
	}


	public void setVod_name(String Vod_name) {
		this.Vod_name = Vod_name;
	}

	public String  getVod_id() {
		return Vod_id;
	}


	public void setVod_id(String Vod_id) {
		this.Vod_id = Vod_id;
	}

	@Override
	public String toString() {
		return "info [Vod_img=" + Vod_img + ",  Vod_name=" +  Vod_name + ",Vod_id=" + Vod_id + ",Vod_update=" + Vod_update + ",Vod_score=" + Vod_score + ",Vod_actor=" + Vod_actor + "]";
	}
	
}
