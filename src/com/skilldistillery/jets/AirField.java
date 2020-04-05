  package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.List;

/*
 * User Story 2: Airfield class holds an empty list of Jets
 */
public class AirField {
	private List<Jet> jets;

	public AirField() {
		jets = new ArrayList<>();
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> _jets) {
		jets = _jets;
	}
}