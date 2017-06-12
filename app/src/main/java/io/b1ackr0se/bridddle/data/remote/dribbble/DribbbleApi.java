package io.b1ackr0se.bridddle.data.remote.dribbble;


import java.util.List;

import io.b1ackr0se.bridddle.data.model.Comment;
import io.b1ackr0se.bridddle.data.model.Like;
import io.b1ackr0se.bridddle.data.model.LikedShot;
import io.b1ackr0se.bridddle.data.model.Shot;
import io.b1ackr0se.bridddle.data.model.User;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface DribbbleApi {
  String ENDPOINT = "https://api.dribbble.com/";
  String AUTH_HEADER = "Authorization";

  @GET("v1/shots")
  Observable<List<Shot>> getPopular(@Header(AUTH_HEADER) String authorization, @Query("page") Integer page, @Query("per_page") Integer pageSize);

  @GET("v1/user")
  Observable<User> getAuthenticatedUser(@Header(AUTH_HEADER) String authorization);

  @GET("v1/user/likes")
  Observable<List<LikedShot>> getLikesOfAuthenticatedUser(@Header(AUTH_HEADER) String authorization);

  @GET("v1/users/{id}")
  Observable<User> getUser(@Header(AUTH_HEADER) String authorization, @Path("id") int id);

  @GET("v1/user/following/{user}")
  Observable<Response<Void>> following(@Header(AUTH_HEADER) String authorization, @Path("user") int userId);

  @PUT("v1/users/{user}/follow")
  Observable<Void> follow(@Header(AUTH_HEADER) String authorization, @Path("user") int userId);

  @DELETE("v1/users/{user}/follow")
  Observable<Void> unfollow(@Header(AUTH_HEADER) String authorization, @Path("user") int userId);

  @GET("v1/users/{id}/shots")
  Observable<List<Shot>> getUserShots(@Header(AUTH_HEADER) String authorization, @Path("id") int id, @Query("page") Integer page, @Query("per_page") Integer pageSize);

  @GET("v1/shots/{id}/comments")
  Observable<List<Comment>> getComments(@Header(AUTH_HEADER) String authorization, @Path("id") int id, @Query("page") Integer page, @Query("per_page") Integer pageSize);

  @GET("v1/shots/{id}/like")
  Observable<Like> liked(@Header(AUTH_HEADER) String authorization, @Path("id") int shotId);

  @POST("v1/shots/{id}/like")
  Observable<Like> like(@Header(AUTH_HEADER) String authorization, @Path("id") int shotId);

  @DELETE("v1/shots/{id}/like")
  Observable<Like> unlike(@Header(AUTH_HEADER) String authorization, @Path("id") int shotId);
}
