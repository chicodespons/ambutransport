package com.chicodespons.ambutransport.repository;

import com.chicodespons.ambutransport.model.transportteam.TeamMember;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
