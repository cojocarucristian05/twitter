package com.ligaaclabs.twitter.service;

import com.ligaaclabs.twitter.model.Post;
import com.ligaaclabs.twitter.model.User;
import com.ligaaclabs.twitter.repository.PostRepository;
import com.ligaaclabs.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public ResponseEntity<?> addPost(UUID userId, String content) {
        if(userRepository.findById(userId).isEmpty()) {
            return ResponseEntity.badRequest().body("User not found!");
        }

        User user = userRepository.findById(userId).get();
        Post post = new Post();
        post.setDate(LocalDateTime.now());
        post.setId(UUID.randomUUID());
        post.setContent(content);
        post.setUser(user);
        postRepository.save(post);
        user.getPosts().add(post);
        return ResponseEntity.ok("Post added!");
    }

//    @Override
//    public void addPost(User user, Integer id, String content) {
//        Post post = new Post(UUID.randomUUID(), content, LocalDateTime.now(), user);
//        user.getPosts().add(post);
//        postRepository.save(post);
//    }

//    @Override
//    public List<Post> getAllPosts() {
//        return postRepository.getAllPosts();
//    }
//
//    @Override
//    public List<Post> getOwnPostsByTimestamp(User user, LocalDateTime timestamps) {
//        return postRepository.getOwnPostsByTimestamp(user, timestamps);
//    }
//
//    @Override
//    public List<Post> getOwnPosts(User user) {
//        return postRepository.getOwnPosts(user);
//    }
//
//    @Override
//    public Post getPostById(Integer id) {
//        return postRepository.getPostById(id);
//    }

}
