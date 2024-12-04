package com.example.lap11.Service;

import com.example.lap11.ApiResponse.ApiException;
import com.example.lap11.Model.Post;
import com.example.lap11.Repository.CategoryRepository;
import com.example.lap11.Repository.PostRepository;
import com.example.lap11.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;


    public PostService(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public void save(Post post){
        if(post.getCategory_id().equals(categoryRepository.findCategoriesById(post.getCategory_id())) && post.getUserId().equals(userRepository.findUserById(post.getUserId()))){
            post.setPublishDate(LocalDateTime.now());
            postRepository.save(post);
        }

    }

    public void updatePost(Integer id ,Post post){
        Post post1 = postRepository.findPostById(id);

        if(post1 != null){
            post1.setTitle(post.getTitle());
            post1.setContent(post.getContent());
            post1.setPublishDate(LocalDateTime.now());
            postRepository.save(post1);
        }
        throw new ApiException("post not found");
    }

    public void deletePost(Integer id){
        Post post1 = postRepository.findPostById(id);
        if(post1 != null){
            postRepository.delete(post1);
        }
        throw new ApiException("post not found");
    }

    public List findPostByUserId(Integer user_id){
        List list = postRepository.findPostByUser_id(user_id);
        if (list.isEmpty()){
            throw new ApiException("post not found");
        }
        return list;
    }

    public List findByPublish_date(LocalDate publish_date){
        List list = postRepository.findPostByPublish_date(publish_date);
        if (list.size() == 0){
            throw new ApiException("post not found");
        }
        return list;
    }


   public List findPostByCategoryId(Integer category_id){
        List list = postRepository.findPostByCategory(category_id);
        if (list.size() == 0){
            throw new ApiException("post not found");
        }
        return list;
   }


   public Post findPostByUserId(String title , Integer user_id){
        Post post = postRepository.findPostByTitleAndUserId(title, user_id);
        if (post == null){
            throw new ApiException("post not found");
        }
        return post;
   }

   public List findByBetweenTwoDate(LocalDate startDate, LocalDate endDate){
        List list = postRepository.findPostByPublishDateBetween(startDate, endDate);
        if (list.size() == 0){
            throw new ApiException("post not found");
        }
        return list;
   }




}
