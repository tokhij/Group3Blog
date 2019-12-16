package com.zipcode.group3blog.service;

import org.springframework.stereotype.Service;

@Service
public class PostService {
//    @Autowired
//    private AuthService authService;
//    @Autowired
//    private PostRepository postRepository;
//
//    @Transactional
//    public List<PostDTO> showAllPosts() {
//        List<Post> posts = postRepository.findAll();
//        return posts.stream().map(this::mapFromPostToDTO).collect(toList());
//    }
//
//    @Transactional
//    public void createPost(PostDTO postDto) {
//        Post post = mapFromDTOToPost(postDto);
//        postRepository.save(post);
//    }
//
//    @Transactional
//    public PostDTO readSinglePost(Long id) {
//        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
//        return mapFromPostToDTO(post);
//    }
//
//    private PostDTO mapFromPostToDTO(Post post) {
//        PostDTO postDTO = new PostDTO();
//        postDTO.setId(post.getId());
//        postDTO.setTitle(post.getTitle());
//        postDTO.setContent(post.getContent());
//        postDTO.setUsername(post.getAuthor());
//        return postDTO;
//    }
//
//    private Post mapFromDTOToPost(PostDTO postDTO) {
//        Post post = new Post();
//        post.setTitle(postDTO.getTitle());
//        post.setContent(postDTO.getContent());
//        Users loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("Users Not Found"));
//        post.setCreatedOn(Instant.now());
//        post.setAuthor(loggedInUser.getUsername());
//        post.setUpdatedOn(Instant.now());
//        return post;
//    }
}
