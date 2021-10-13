<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>MM Blog</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Custom icon font-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/fontastic.css">
    <!-- Google fonts - Open Sans-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <!-- Fancybox-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/vendor/@fancyapps/fancybox/jquery.fancybox.min.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="favicon.png">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <jsp:include page="include-front-header.jsp"></jsp:include>
    
    <div class="container">
      <div class="row">
      
      
        <!-- Latest Posts -->
        <main class="post blog-post col-lg-8"> 
          <div class="container">
            <div class="post-single">
              <div class="post-thumbnail"><img src="href="${blog.image}" alt="" class="img-fluid"></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="category"><a href="blog-category?id=${blog.category.id}">${blog.category.name}</a></div>
                </div>
                <h1>${blog.title}<a href="#"><i class="fa fa-bookmark-o"></i></a></h1>
                <div class="post-footer d-flex align-items-center flex-column flex-sm-row"><a href="blog-author?id=${blog.author.id}" class="author d-flex align-items-center flex-wrap">
                    <div class="avatar"><img src="href="${blog.author.image}" alt="" class="img-fluid"></div>
                    <div class="title"><span>${blog.author.name} ${blog.author.surname}</span></div></a>
                  <div class="d-flex align-items-center flex-wrap">       
                    <div class="date"><i class="icon-clock"></i> 2 months ago</div>
                    <div class="views"><i class="icon-eye"></i> 500</div>
                    <div class="comments meta-last"><a href="#post-comments"><i class="icon-comment"></i>12</a></div>
                  </div>
                </div>
                <div class="post-body">
                  <p class="lead">${blog.description}</p>
                  <p>${blog.content}</p>
                  <p> <img src="${pageContext.request.contextPath}/front/img/featured-pic-3.jpeg" alt="..." class="img-fluid"></p>
                  <h3>Lorem Ipsum Dolor</h3>
                  <p>div Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda temporibus iusto voluptates deleniti similique rerum ducimus sint ex odio saepe. Sapiente quae pariatur ratione quis perspiciatis deleniti accusantium</p>
                  <blockquote class="blockquote">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip.</p>
                    <footer class="blockquote-footer">Someone famous in
                      <cite title="Source Title">Source Title</cite>
                    </footer>
                  </blockquote>
                  <p>quasi nam. Libero dicta eum recusandae, commodi, ad, autem at ea iusto numquam veritatis, officiis. Accusantium optio minus, voluptatem? Quia reprehenderit, veniam quibusdam provident, fugit iusto ullam voluptas neque soluta adipisci ad.</p>
                </div>
                
                
                <div class="post-tags"><a href="blog-tag.html" class="tag">#Business</a><a href="blog-tag.html" class="tag">#Tricks</a><a href="blog-tag.html" class="tag">#Financial</a><a href="blog-tag.html" class="tag">#Economy</a></div>
                
                
                <div class="posts-nav d-flex justify-content-between align-items-stretch flex-column flex-md-row"><a href="#" class="prev-post text-left d-flex align-items-center">
                    <div class="icon prev"><i class="fa fa-angle-left"></i></div>
                    <div class="text"><strong class="text-primary">Previous Post </strong>
                      <h6>I Bought a Wedding Dress.</h6>
                    </div></a><a href="#" class="next-post text-right d-flex align-items-center justify-content-end">
                    <div class="text"><strong class="text-primary">Next Post </strong>
                      <h6>I Bought a Wedding Dress.</h6>
                    </div>
                    <div class="icon next"><i class="fa fa-angle-right">   </i></div></a></div>
                <div class="post-comments" id="post-comments">
                  <header>
                    <h3 class="h6">Post Comments<span class="no-of-comments">(3)</span></h3>
                  </header>
                  <div class="comment">
                    <div class="comment-header d-flex justify-content-between">
                      <div class="user d-flex align-items-center">
                        <div class="image"><img src="href="${pageContext.request.contextPath}/front/img/user.svg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="title"><strong>Jabi Hernandiz</strong><span class="date">May 2016</span></div>
                      </div>
                    </div>
                    <div class="comment-body">
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.</p>
                    </div>
                  </div>
                  <div class="comment">
                    <div class="comment-header d-flex justify-content-between">
                      <div class="user d-flex align-items-center">
                        <div class="image"><img src="href="${pageContext.request.contextPath}/front/img/user.svg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="title"><strong>Nikolas</strong><span class="date">May 2016</span></div>
                      </div>
                    </div>
                    <div class="comment-body">
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.</p>
                    </div>
                  </div>
                  <div class="comment">
                    <div class="comment-header d-flex justify-content-between">
                      <div class="user d-flex align-items-center">
                        <div class="image"><img src="href="${pageContext.request.contextPath}/front/img/user.svg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="title"><strong>John Doe</strong><span class="date">May 2016</span></div>
                      </div>
                    </div>
                    <div class="comment-body">
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.</p>
                    </div>
                  </div>
                </div>
                <div class="add-comment">
                  <header>
                    <h3 class="h6">Leave a reply</h3>
                  </header>
                  <form action="#" class="commenting-form">
                    <div class="row">
                      <div class="form-group col-md-6">
                        <input type="text" name="username" id="username" placeholder="Name" class="form-control">
                      </div>
                      <div class="form-group col-md-6">
                        <input type="email" name="username" id="useremail" placeholder="Email Address (will not be published)" class="form-control">
                      </div>
                      <div class="form-group col-md-12">
                        <textarea name="usercomment" id="usercomment" placeholder="Type your comment" class="form-control"></textarea>
                      </div>
                      <div class="form-group col-md-12">
                        <button type="submit" class="btn btn-secondary">Submit Comment</button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </main>
        
        
         <jsp:include page="include-aside-front.jsp"></jsp:include>
         
      </div>
    </div>
    <!-- Page Footer-->
<jsp:include page="include-front-footer.jsp"></jsp:include>


    <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath}/front/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/front/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath}/front/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/front/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath}/front/vendor/@fancyapps/fancybox/jquery.fancybox.min.js"></script>
    <script src="${pageContext.request.contextPath}/front/js/front.js"></script>
  </body>
</html>