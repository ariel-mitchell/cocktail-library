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
               s += '<option th:text="${ingredients[i].name}" th:value="${ingredients[i].id}"></option>';
             }
             $('#ingredient').html(s);
       }
   }


   function addAnother() {
    return true;
   }
