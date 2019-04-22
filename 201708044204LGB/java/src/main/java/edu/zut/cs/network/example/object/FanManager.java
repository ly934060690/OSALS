package edu.zut.cs.network.example.object;

import java.util.List;

public interface FanManager {

	/**
	 * fetch all fans;
	 * 
	 * @return list of all fans;
	 */
	public List<Fan> getAll();

	/**
	 * fetch a fan according to given Id;;
	 * 
	 * @return a specific fan;
	 */
	public Fan getById(Long Id);

}
