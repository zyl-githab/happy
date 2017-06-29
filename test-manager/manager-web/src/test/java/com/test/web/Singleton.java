package com.test.web;

/**
 * 
 * @author Administrator
 * @deprecated 单例设计模式-饱汉模式
 */
public class Singleton {

	private static Singleton SingletonTest = null;

	public Singleton() {
	}

	public static Singleton getInstance() {
		if (SingletonTest == null) {
			SingletonTest = new Singleton();
		}
		return SingletonTest;
	}
}
