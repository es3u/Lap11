package com.example.lap11.Service;

import com.example.lap11.ApiResponse.ApiException;
import com.example.lap11.Model.Comment;
import com.example.lap11.Repository.CommentRepository;
import com.example.lap11.Repository.PostRepository;
import com.example.lap11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public void save(Comment comment) {
        if(comment.getPostId().equals(postRepository.findPostById(comment.getPostId())) && comment.getIUserd().equals(userRepository.findUserById(comment.getIUserd()))) {
            comment.setCommentDate(LocalDateTime.now());
            commentRepository.save(comment);
        }


    }
    public void updateComment(Integer id ,Comment comment) {
        Comment oldComment = commentRepository.findCommentById(id);
        if (oldComment != null) {
            oldComment.setCommentDate(LocalDateTime.now());
            oldComment.setComment(comment.getComment());
            //oldComment.setUId(comment.getUId());
            oldComment.setPostId(comment.getPostId());
            commentRepository.save(oldComment);
        }
        throw new ApiException("Comment not found");
    }

    public void deleteComment(Integer id) {
        Comment oldComment = commentRepository.findCommentById(id);
        if (oldComment != null) {
            commentRepository.delete(oldComment);
        }
        throw new ApiException("Comment not found");
    }

    public List<Comment> findCommentByUId(Integer post_id) {
        List list = commentRepository.findCommentByUId(post_id);
        if (list.size() > 0) {
             throw new ApiException("Comment not found");
        }
        return list;
    }

    public Comment findCommentByPostAndDateAndUserID(Integer id, Integer postId, LocalDate date){
        Comment commentc = commentRepository.findCommentByUIdAndPostIdAndCommentDate(id, postId, date);
        if (commentc != null) {
            return commentc;
        }
        throw new ApiException("Comment not found");
    }
}
