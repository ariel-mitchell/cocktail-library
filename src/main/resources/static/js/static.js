    $(document).ready(function() {
          $("#ingredientType").change(function() {
              ingredientTypeSelected();
          });
      });
          function ingredientTypeSelected() {
          let selectedType = $("#ingredientType").val();
          let s;
          for (i=0;i<ingredients.length;i++) {
              if (ingredients[i].ingredientType == selectedType) {
                  s +=  '<option value="' + ingredients[i].id + '">'+ ingredients[i].name+ '</option>';
                }
                $('#ingredientName').html(s);
          }
      }

//   $(document).ready(function() {
//     $("#anotherBtn").click(function() {
//     addAnotherIngredient();
//     });
//   });
     function addAnotherIngredient() {
     alert("You've clicked the button!");

     let ingredientList = document.getElementById('ingredientForm');
     let currentHTML = ingredientList.innerHTML;
     let newHTML = '<div class="form-row"> <label th:for="ingredient" id="ingredient">Ingredient</label> <label th:for="ingredientType">Ingredient Type</label> <select id="ingredientType"> <option value="">Select Ingredient Type</option> <option th:each="ingredientType : ${ingredientTypes}" th:text="${ingredientType.displayName}" th:value="${ingredientType}"></option> </select> <label th:for="ingredientName">Ingredient Name</label> <select id="ingredientName"> <option>Select Ingredient</option> </select> <label th:for="ingredientAmount">Ingredient Amount</label> <select id="ingredientAmount"> <option value="">Select Ingredient Amount</option> <!--                <option th:each="ingredientAmount : ${ingredientAmounts}"--> <!--                        th:text="${ingredientAmount.displayName}"--> <!--                        th:value="${ingredientAmount}">Select Ingredient Amount</option>--> </select> </div>'

     ingredientList.innerHTML = currentHTML + newHTML;
     }



