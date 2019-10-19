package corePakage;

public class SensorData {
	
	private int id;
	private String user;
	private String timestamp;
	private String uom;
	private String type;
	private float value;
	
	public SensorData() {
		this.id = 0;
		this.user = "";
		this.timestamp = "";
		this.uom = "";
		this.type = "";
		this.value = 0;	
	}
	
	public SensorData(int nid,String nuser,String ntimestamp, String nuom,String ntype,float nvalue) {	
		this.id = nid;
		this.user = nuser;
		this.timestamp = ntimestamp;
		this.uom = nuom;
		this.type = ntype;
		this.value = nvalue;	
	}
	

}
