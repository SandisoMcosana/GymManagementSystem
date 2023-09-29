package za.ac.cput.service;

import za.ac.cput.domain.Member;

import java.util.List;

public interface IMemberService extends IService<Member, Integer>{
    List<Member> getAll();
}
