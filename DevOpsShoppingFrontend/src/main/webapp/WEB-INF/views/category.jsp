<c:url value="/addcategory" var="cat"/>
          <form:form action="${cat}" method="post" commandName="category">
          
            <div class="field-wrap">
            <label>
              Category Id<span class="req">*</span>
            </label>
            <form:input type="text" required="required" autocomplete="off" path="catId"/>
          </div>
          
          <div class="field-wrap">
            <label>
             Category Name<span class="req">*</span>
            </label>
            <form:input type="text" required="required" autocomplete="off" path="catName"/>
          </div>
                    
          <button class="button button-block">Submit</button>
          
          </form:form>