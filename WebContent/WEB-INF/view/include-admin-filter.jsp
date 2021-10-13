<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="col-12">
	<!-- Default box -->
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Search by Filters</h3>

			<div class="card-tools">
				<button type="button" class="btn btn-tool"
					data-card-widget="collapse" data-toggle="tooltip" aria-expanded="false" title="Collapse">
					<i class="fa fa-minus"></i>
				</button>
			</div>
		</div>
		
		<!-- /.card-header -->
		<div class="card-body">
			
			
			<form:form id="entities-filter-form">
				<div class="row">



					<div class="col-md-3 form-group">
						<label>Name</label> <input type="text" class="form-control"
							placeholder="Name">
                    
                  
					</div>
					<div class="col-md-3 form-group">
						<label>Status</label> <select class="form-control">
							<option>-- All --</option>
							<option value="1">Enabled</option>
							<option value="2">Disabled</option>

						</select>
					</div>
					<div class="col-md-3 form-group">
						<label>Category</label> <select class="form-control">
							<option>-- All --</option>
							
									<option value="1">Kategorija 1</option>
									<option value="2">Kategorija 2</option>
									<option value="3">Kategorija 3</option>
									<option value="4">Kategorija 4</option>
							
						</select>

					</div>
					<div class="col-md-3 form-group">
						<label>Created By</label> <input type="text" class="form-control"
							placeholder="Search blogger">
					</div>
					
					
					
					
				</div>
			</form:form>
		</div>
		<!-- /.card-body -->
		<div class="card-footer clearfix"></div>




		<!-- /.card-body -->
		<div class="card-footer">
		
		
                      <button type="button" class="btn btn-block btn-success">Apply</button>
                    
		
		
		</div>
		<!-- /.card-footer-->
	</div>
	<!-- /.card -->
</div>
