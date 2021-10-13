 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
        <aside class="col-lg-4">
          <!-- Widget [Search Bar Widget]-->
          <div class="widget search">
            <header>
              <h3 class="h6">Search the blog</h3>
            </header>
            <form action="blog-search.html" class="search-form">
              <div class="form-group">
                <input type="search" placeholder="What are you looking for?">
                <button type="submit" class="submit"><i class="icon-search"></i></button>
              </div>
            </form>
          </div>
          <!-- Widget [Latest Posts Widget]        -->
          <div class="widget latest-posts">
            <header>
              <h3 class="h6">Latest Posts</h3>
            </header>
            <div class="blog-posts">

	<c:forEach var="blog" items="${lastThreeBlogs}">
			<a href="blog-post?id=${blog.id}">
                <div class="item d-flex align-items-center">
                  <div class="image"><img src="front/img/small-thumbnail-2.jpg" alt="" class="img-fluid"></div>
                  <div class="title"><strong>${blog.title}</strong>
                    <div class="d-flex align-items-center">
                      <div class="views"><i class="icon-eye"></i> 500</div>
                      <div class="comments"><i class="icon-comment"></i>12</div>
                    </div>
                  </div>
                </div></a></c:forEach>
                
                </div>
          </div>
          <!-- Widget [Categories Widget]-->
          <div class="widget categories">
            <header>
              <h3 class="h6">Categories</h3>
            </header>
            
            <c:forEach var="category" items="${categoriesOrder}">
            
            	<div class="item d-flex justify-content-between"><a href="blog-category?id=${category.id}">${category.name}</a><span>${category.numberOfBlogs}</span></div>
            
            </c:forEach>
        
          </div>
          <!-- Widget [Tags Cloud Widget]-->
          <div class="widget tags">       
            <header>
              <h3 class="h6">Tags</h3>
            </header>
            
            
            <ul class="list-inline">
	            <c:forEach var="tag" items="${tagsAside}">
	             	 <li class="list-inline-item"><a href="blog-tag?id=${tag.id}" class="tag">#${tag.name}</a></li>
	              </c:forEach>
            </ul>
            
            
          </div>
        </aside>