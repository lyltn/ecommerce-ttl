<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="connect.Dao"%>
<%@ page import="java.util.Vector"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en"> 
<head>
    <title>TTL</title>
    
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <meta name="description" >
    <meta name="author" content="Xiaoying Riley at 3rd Wave Media">    
    <link rel="shortcut icon" href="favicon.ico"> 
    
    <!-- FontAwesome JS-->
    <script defer src="assets/plugins/fontawesome/js/all.min.js"></script>
    
    <!-- App CSS -->  
    <link id="theme-style" rel="stylesheet" href="assets/css/portal.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	

</head> 

<body class="app">  
  	
    <header class="app-header fixed-top">	   	            
        <div class="app-header-inner">  
	        <div class="container-fluid py-2">
		        <div class="app-header-content"> 
		            <div class="row justify-content-between align-items-center">    
				    <div class="col-auto">
					    <a id="sidepanel-toggler" class="sidepanel-toggler d-inline-block d-xl-none" href="#">
						    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 30 30" role="img"><title>Menu</title><path stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10" stroke-width="2" d="M4 7h22M4 15h22M4 23h22"></path></svg>
					    </a>
				    </div><!--//col-->
		            <div class="app-utilities col-auto">
			            <div class="app-utility-item app-user-dropdown dropdown">
				            <a class="dropdown-toggle" id="user-dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false"><img src="assets/images/user.png" alt="user profile"></a>
				            <ul class="dropdown-menu" aria-labelledby="user-dropdown-toggle">
								<li><a class="dropdown-item" href="cliaccount.jsp">Account</a></li>
								<li><a class="dropdown-item" href="cusindex.jsp"><i class="bi bi-arrow-left-right"></i> Customer</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="login.jsp">Log Out</a></li>
							</ul>
			            </div><!--//app-user-dropdown--> 
		            </div><!--//app-utilities-->
		        </div><!--//row-->
	            </div><!--//app-header-content-->
	        </div><!--//container-fluid-->
        </div><!--//app-header-inner-->
        <div id="app-sidepanel" class="app-sidepanel"> 
	        <div id="sidepanel-drop" class="sidepanel-drop"></div>
	        <div class="sidepanel-inner d-flex flex-column">
		        <a href="#" id="sidepanel-close" class="sidepanel-close d-xl-none">&times;</a>
		        <div class="app-branding">
		            <a class="app-logo" href="cliindex.jsp"><img class="logo-icon me-2" src="assets/images/app-logo.svg" alt="logo"><span class="logo-text">TTL</span></a>
	
		        </div><!--//app-branding-->  
		        
			    <nav id="app-nav-main" class="app-nav app-nav-main flex-grow-1">
				    <ul class="app-menu list-unstyled accordion" id="menu-accordion">
					    <li class="nav-item">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link" href="cliindex.jsp">
						        <span class="nav-icon">
									<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house-door" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
										<path fill-rule="evenodd" d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z"/>
										<path fill-rule="evenodd" d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
									  </svg>
						         </span>
		                         <span class="nav-link-text">Overview</span>
					        </a><!--//nav-link-->
					    </li><!--//nav-item-->

						<li class="nav-item">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link" href="cliorders.jsp">
						        <span class="nav-icon">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-seam" viewBox="0 0 16 16">
										<path d="M8.186 1.113a.5.5 0 0 0-.372 0L1.846 3.5l2.404.961L10.404 2zm3.564 1.426L5.596 5 8 5.961 14.154 3.5zm3.25 1.7-6.5 2.6v7.922l6.5-2.6V4.24zM7.5 14.762V6.838L1 4.239v7.923zM7.443.184a1.5 1.5 0 0 1 1.114 0l7.129 2.852A.5.5 0 0 1 16 3.5v8.662a1 1 0 0 1-.629.928l-7.185 2.874a.5.5 0 0 1-.372 0L.63 13.09a1 1 0 0 1-.63-.928V3.5a.5.5 0 0 1 .314-.464z"/>
									  </svg>
						         </span>
		                         <span class="nav-link-text">Orders</span>
					        </a><!--//nav-link-->
					    </li><!--//nav-item-->
					    <li class="nav-item has-submenu">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link submenu-toggle active" href="#" data-bs-toggle="collapse" data-bs-target="#submenu-1" aria-expanded="true" aria-controls="submenu-1">
						        <span class="nav-icon">
						        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-files" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  <path fill-rule="evenodd" d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z"/>
	  <path d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z"/>
	</svg>
						         </span>
		                         <span class="nav-link-text">Product</span>
		                         <span class="submenu-arrow">
		                             <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  <path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
	</svg>
	                             </span><!--//submenu-arrow-->
					        </a><!--//nav-link-->
					        <div id="submenu-1" class="collapse submenu submenu-1 show" data-bs-parent="#menu-accordion">
						        <ul class="submenu-list list-unstyled">
							        <li class="submenu-item"><a class="submenu-link active" href="clilistproduct.jsp">List Product</a></li>
							        <li class="submenu-item"><a class="submenu-link" href="cliaddproduct.jsp">Add Product</a></li>
							        
							        
						        </ul>
					        </div>
					    </li><!--//nav-item-->
						<li class="nav-item">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link" href="clicategory.jsp">
						        <span class="nav-icon">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
										<path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1"/>
									  </svg>
						         </span>
		                         <span class="nav-link-text">Categorys</span>
					        </a><!--//nav-link-->
					    </li><!--//nav-item-->
						<li class="nav-item">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link" href="clibrand.jsp">
						        <span class="nav-icon">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
										<path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1"/>
									  </svg>
						         </span>
		                         <span class="nav-link-text">Brands</span>
					        </a><!--//nav-link-->
					    </li><!--//nav-item-->
						<li class="nav-item">
					        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
					        <a class="nav-link" href="clivoucher.jsp">
						        <span class="nav-icon">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cassette" viewBox="0 0 16 16">
										<path d="M4 8a1 1 0 1 0 0-2 1 1 0 0 0 0 2m9-1a1 1 0 1 1-2 0 1 1 0 0 1 2 0M7 6a1 1 0 0 0 0 2h2a1 1 0 1 0 0-2z"/>
										<path d="M1.5 2A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2zM1 3.5a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-.691l-1.362-2.724A.5.5 0 0 0 12 10H4a.5.5 0 0 0-.447.276L2.19 13H1.5a.5.5 0 0 1-.5-.5zM11.691 11l1 2H3.309l1-2z"/>
									  </svg>
						         </span>
		                         <span class="nav-link-text">Vouchers</span>
					        </a><!--//nav-link-->
					    </li><!--//nav-item-->
					    

					    
				    
				    </ul><!--//app-menu-->
			    </nav><!--//app-nav-->

		       
	        </div><!--//sidepanel-inner-->
	    </div><!--//app-sidepanel-->
    </header><!--//app-header-->
    
    <div class="app-wrapper">
	    
	    <div class="app-content pt-3 p-md-3 p-lg-4">
		    <div class="container-xl">
			    <div class="row g-3 mb-4 align-items-center justify-content-between">
				    <div class="col-auto">
			            <h1 class="app-page-title mb-0">List Product</h1>
				    </div>
				    <div class="col-auto">
					     <div class="page-utilities">
						    <div class="row g-2 justify-content-start justify-content-md-end align-items-center">
							    <div class="col-auto">
								    <form class="docs-search-form row gx-1 align-items-center">
					                    <div class="col-auto">
					                        <input type="text" id="search-docs" name="searchdocs" class="form-control search-docs" placeholder="Search">
					                    </div>
					                    <div class="col-auto">
					                        <button type="submit" class="btn app-btn-primary"><i class="bi bi-search"></i></button>
					                    </div>
					                </form>  
							    </div><!--//col-->
								<div class="col-auto">
								<form class="docs-search-form row gx-1 align-items-center">
								    <select class="form-select w-auto">
										  <option selected="" value="option-1">All</option>
										  <option value="option-2">Text file</option>
										  <option value="option-3">Image</option>
										  <option value="option-4">Spreadsheet</option>
										  <option value="option-5">Presentation</option>
										  <option value="option-6">Zip file</option>  
									</select>
									<div class="col-auto">
										<button type="submit" class="btn app-btn-secondary">Category</button>
									</div>
								</form>
							    </div>
						    </div><!--//row-->
					    </div><!--//table-utilities-->
				    </div><!--//col-auto-->
			    </div><!--//row-->

				<nav id="orders-table-tab" class="orders-table-tab app-nav-tabs nav shadow-sm flex-column flex-sm-row mb-4">
				    <a class="flex-sm-fill text-sm-center nav-link active"  id="orders-active-tab" data-bs-toggle="tab" href="#orders-active" role="tab" aria-controls="orders-active" aria-selected="true">Active</a>
				    <a class="flex-sm-fill text-sm-center nav-link" id="orders-hide-tab" data-bs-toggle="tab" href="#orders-hide" role="tab" aria-controls="orders-hide" aria-selected="false">Hide</a>
				</nav>

				<div class="tab-content" id="orders-table-tab-content">
			        <div class="tab-pane fade show active" id="orders-active" role="tabpanel" aria-labelledby="orders-active-tab">
			    
			    <div class="row g-4">
					
					<c:forEach items="${productList}" var="product" varStatus="status">
					    <c:set var="price" value="${priceList[status.index]}" />
					
					    <div class="col-6 col-md-4 col-xl-3 col-xxl-2">
					        <div class="app-card app-card-doc shadow-sm h-100">
					            <div class="app-card-thumb-holder p-3">
					                <div class="app-card-thumb">
					                    <img class="thumb-image" src="${pageContext.request.contextPath}/ImageServlet?id=${product.id}" alt="">
					                </div>
					                <a class="app-card-link-mask" href="#file-link"></a>
					            </div>
					            <div class="app-card-body p-3 has-card-actions">
					                <h4 class="app-doc-title truncate mb-1">
					                    <a href="#file-link">${product.name}</a>
					                </h4>
					                <div class="app-doc-meta">
					                    <ul class="list-unstyled mb-0">
					                        <li class="mb-2">
					                            <span class="app-doc-title text-danger">${price}</span> vnd
					                        </li>
					                        <li class="d-flex">
					                            <div class="d-flex mt-1">
					                                <i class="fa fa-star text-warning"></i>
					                                <i class="fa fa-star text-warning"></i>
					                                <i class="fa fa-star text-warning"></i>
					                                <i class="fa fa-star text-warning"></i>
					                                <i class="fa fa-star"></i>
					                            </div>
					                            <div class="ms-1 app-doc-title">4.5</div>
					                        </li>
					                    </ul>
					                </div><!--//app-doc-meta-->
					                <div class="app-card-actions">
					                    <div class="dropdown">
					                        <div class="dropdown-toggle no-toggle-arrow" data-bs-toggle="dropdown" aria-expanded="false">
					                            <i class="bi bi-three-dots-vertical"></i>
					                        </div><!--//dropdown-toggle-->
					                        <ul class="dropdown-menu">
					                            <li><a class="dropdown-item" href="#"><i class="bi bi-eye-slash me-1"></i> Hide</a></li>
					                            <li><hr class="dropdown-divider"></li>
					                            <li><a class="dropdown-item" href="#"><i class="bi bi-pencil me-1"></i> Edit</a></li>
					                        </ul>
					                    </div><!--//dropdown-->
					                </div><!--//app-card-actions-->
					            </div><!--//app-card-body-->
					        </div><!--//app-card-->
					    </div><!--//col-->
					</c:forEach>

			    </div><!--//row-->
			    
			    
			    
			    
			</div>

			<div class="tab-pane fade" id="orders-hide" role="tabpanel" aria-labelledby="orders-hide-tab">


				<div class="row g-4">

				    <div class="col-6 col-md-4 col-xl-3 col-xxl-2">
					    <div class="app-card app-card-doc shadow-sm  h-100">
						    <div class="app-card-thumb-holder p-3">
							    <div class="app-card-thumb">
	                                <img class="thumb-image" src="assets/images/doc-thumb-1.jpg" alt="">
	                            </div>
	                             <a class="app-card-link-mask" href="#file-link"></a>
						    </div>
						    <div class="app-card-body p-3 has-card-actions">
							    
							    <h4 class="app-doc-title truncate mb-1"><a href="#file-link">Image lorem ipsum dolor sit amet</a></h4>
							    <div class="app-doc-meta">
								    <ul class="list-unstyled mb-0">
									    <li class="mb-2"><span class="app-doc-title text-danger">35000 </span> vnd</li>
									    <li class="d-flex">
											<div class="d-flex mt-1">
												<i class="fa fa-star text-warning"></i>
												<i class="fa fa-star text-warning"></i>
												<i class="fa fa-star text-warning"></i>
												<i class="fa fa-star text-warning"></i>
												<i class="fa fa-star "></i>
											</div>
											<div class="ms-1 app-doc-title">4.5</div>
										</li>
								    </ul>
							    </div><!--//app-doc-meta-->
							    <div class="app-card-actions">
								    <div class="dropdown">
									    <div class="dropdown-toggle no-toggle-arrow" data-bs-toggle="dropdown" aria-expanded="false">
										    <i class="bi bi-three-dots-vertical"></i>
									    </div><!--//dropdown-toggle-->
									    <ul class="dropdown-menu">
											<li><a class="dropdown-item" href="#"><i class="bi bi-eye me-1"></i> Active</a></li>
											<li><hr class="dropdown-divider"></li>
											<li><a class="dropdown-item" href="#"><i class="bi bi-pencil me-1"></i> Edit</a></li>
	                                        
										
										</ul>
								    </div><!--//dropdown-->
						        </div><!--//app-card-actions-->		    
						    </div><!--//app-card-body-->
						</div><!--//app-card-->
				    </div><!--//col-->

			    </div><!--//row-->


			</div>
		</div>


		    </div><!--//container-fluid-->
	    </div><!--//app-content-->
	    
	    <footer class="app-footer">

	    </footer><!--//app-footer-->
	    
    </div><!--//app-wrapper-->    					

 
    <!-- Javascript -->          
    <script src="assets/plugins/popper.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>  

    
    <!-- Page Specific JS -->
    <script src="assets/js/app.js"></script> 

</body>
</html> 

