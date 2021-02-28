package Model;

public class Objects implements Comparable<Objects> {

	private String name;
	private int nit;
	
	public Objects(String name, int nit) {
		this.setName(name);
		this.setNit(nit);
	}
	
	@Override
	public int compareTo(Objects ob) {
		int res = 0;
		if(nit>ob.getNit()) {
			res = -1;
		}else if(nit<ob.getNit()) {
			res = 1;
		}else {
			res = 0; 
		}
		return res;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

}
