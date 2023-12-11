package com.ji.springP001.Member;

import java.util.List;

public interface memberMapper {
	
	public abstract List<Member> searchMember(Member m);
	public abstract void regMember(Member m);
	public abstract void updateMember(Member m);
	public abstract void leaveMember(Member m);
	
}
