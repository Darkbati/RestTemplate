package com.template.rest.model;

public class RequestModel {
	private String pid;
	private Integer accountUniqueID;
	private Integer gold;
	private Integer topaz;
	private Integer rubyCash;
	private Integer rubyFree;
	private Integer honorPoint;
	private Integer siegePoint;
	private Integer rushDungeonPoint;
	private Integer guildCoin;
	private Integer worldBossPoint;

	public RequestModel() {
		this.pid = "";
		this.accountUniqueID = 0;
		this.gold = 0;
		this.topaz = 0;
		this.rubyCash = 0;
		this.rubyFree = 0;
		this.honorPoint = 0;
		this.siegePoint = 0;
		this.rushDungeonPoint = 0;
		this.guildCoin = 0;
		this.worldBossPoint = 0;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getAccountUniqueID() {
		return accountUniqueID;
	}

	public void setAccountUniqueID(Integer accountUniqueID) {
		this.accountUniqueID = accountUniqueID;
	}
	
	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Integer getTopaz() {
		return topaz;
	}

	public void setTopaz(Integer topaz) {
		this.topaz = topaz;
	}

	public Integer getRubyCash() {
		return rubyCash;
	}

	public void setRubyCash(Integer rubyCash) {
		this.rubyCash = rubyCash;
	}

	public Integer getRubyFree() {
		return rubyFree;
	}

	public void setRubyFree(Integer rubyFree) {
		this.rubyFree = rubyFree;
	}

	public Integer getHonorPoint() {
		return honorPoint;
	}

	public void setHonorPoint(Integer honorPoint) {
		this.honorPoint = honorPoint;
	}

	public Integer getSiegePoint() {
		return siegePoint;
	}

	public void setSiegePoint(Integer siegePoint) {
		this.siegePoint = siegePoint;
	}

	public Integer getRushDungeonPoint() {
		return rushDungeonPoint;
	}

	public void setRushDungeonPoint(Integer rushDungeonPoint) {
		this.rushDungeonPoint = rushDungeonPoint;
	}

	public Integer getGuildCoin() {
		return guildCoin;
	}

	public void setGuildCoin(Integer guildCoin) {
		this.guildCoin = guildCoin;
	}

	public Integer getWorldBossPoint() {
		return worldBossPoint;
	}

	public void setWorldBossPoint(Integer worldBossPoint) {
		this.worldBossPoint = worldBossPoint;
	}

}
