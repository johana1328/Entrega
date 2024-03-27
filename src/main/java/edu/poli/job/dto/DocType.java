package edu.poli.job.dto;

public enum DocType {
	CC(1), CE(2), NIT(3);

	private int id;

	DocType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static DocType randomType() {
		double rand = Math.floor(Math.random() * (3 - 1 + 1)) + 1;
		int radInt = (int)rand;
		for (DocType in : values()) {
			if (radInt == in.getId()) {
				return in;
			}
		}
		return DocType.CC;
	}

}
