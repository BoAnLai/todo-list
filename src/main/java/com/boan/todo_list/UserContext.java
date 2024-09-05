package com.boan.todo_list;

public class UserContext {

	private static final ThreadLocal<UserContext> userContext = ThreadLocal.withInitial(UserContext::new);

	private String ipAddress;

	private UserContext() {
	};

	public static UserContext getCurrent() {
		return userContext.get();
	}

	public static void setIpAddress(String ipAddress) {
		getCurrent().ipAddress = ipAddress;
	}

	public static String getIpAddress() {
		return getCurrent().ipAddress;
	}

	public static void clear() {
		userContext.remove();
	}
}
