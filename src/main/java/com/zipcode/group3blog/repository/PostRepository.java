package com.zipcode.group3blog.repository;

import com.zipcode.group3blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
   Page<Post> getPostPages(Pageable pageable);

}