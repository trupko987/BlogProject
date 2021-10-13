<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<footer class="main-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="logo">
              <h6 class="text-white">MM Blog</h6>
            </div>
            <div class="contact-details">
              <p>Luja Adamiča 34, 11070 Novi Beograd</p>
              <p>Phone: +381 (0)66 40 33 97</p>
              <p>Email: <a href="mailto: mirko_maks@yahoo.com">mirko_maks@yahoo.com</a></p>
              <ul class="social-menu">
                <li class="list-inline-item"><a href="https://twitter.com/trupko987" target="_blank"><i class="fa fa-twitter"></i></a></li>
                <li class="list-inline-item"><a href="https://www.instagram.com/trupko987/?hl=sr" target="_blank"><i class="fa fa-instagram"></i></a></li>
                <li class="list-inline-item"><a href="https://www.linkedin.com/in/mirko-maksimovic-64953b178/" target="_blank"><i class="fa fa-linkedin"></i></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md-4">
            <div class="menus d-flex">
              <ul class="list-unstyled">
                <li> <a href="homepage">Home</a></li>
                <li> <a href="blogs">Blog</a></li>
                <li> <a href="contact">Contact</a></li>
                <li> <a href="#">Login</a></li>
              </ul>
              <ul class="list-unstyled">
                <li> <a href="blog-category.html">Growth</a></li>
                <li> <a href="blog-category.html">Local</a></li>
                <li> <a href="blog-category.html">Sales</a></li>
                <li> <a href="blog-category.html">Tips</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md-4">
            
            <c:forEach var="blog" items="${lastThreeBlogs}">
            <div class="latest-posts"><a href="blog-post?id=${blog.id}">
                <div class="post d-flex align-items-center">
                  <div class="image"><img src="front/img/small-thumbnail-2.jpg" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>${blog.title}</strong><span class="date last-meta">${blog.date}</span></div>
                </div></a></div>
                
                </c:forEach>
                
                
          </div>
        </div>
      </div>
      <div class="copyrights">
        <div class="container">
          <div class="row">
            <div class="col-md-6">
              <p>Copyright &copy; 2021 <a
				href="https://www.mmaksimovic.rs">Mirko Maksimović</a>. All rights reserved.</p>
            </div>
            <div class="col-md-6 text-right">
              <p>Template By <a href="https://cubes.edu.rs/" class="text-white" target = "_blank">Cubes d.o.o.</a>
                <!-- Please do not remove the backlink to Bootstrap Temple unless you purchase an attribution-free license @ Bootstrap Temple or support us at http://bootstrapious.com/donate. It is part of the license conditions. Thanks for understanding :)                         -->
              </p>
            </div>
          </div>
        </div>
      </div>
    </footer>