package com.travel.proj.member;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.proj.bookmark.Bookmark;


public interface MemberRepository
extends JpaRepository<Member, Integer>, CustomRepository {}
