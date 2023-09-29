package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Member;
import za.ac.cput.repository.MemberRepository;

import java.util.List;

@Service
public class MemberService implements IMemberService{
    private MemberRepository repository;

    @Autowired
    private MemberService(MemberRepository memberRepository){
        this.repository = memberRepository;
    }

    @Override
    public Member create(Member member){
        return this.repository.save(member);
    }

    @Override
    public Member read(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Member update(Member member){
        return this.repository.existsById(member.getMemberId()) ? this.repository.save(member) : null;
    }

    @Override
    public boolean delete(Integer id){
        if (this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Member> getAll(){
        return this.repository.findAll();
    }
}
