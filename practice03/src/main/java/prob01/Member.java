package prob01;

public class Member {
	//회원 아이디
	private String id;
	//회원 이름
	private String name;
	//회원 point
	private int point;

	//생성자
	public Member() {
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}