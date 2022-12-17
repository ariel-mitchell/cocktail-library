$(document).ready(function() {});
   function repeatFormElement(current){
    $(current).parents('.form-list').append($(current).parents('.form-list').find('#ingredientForm').clone());
   }

   function ingredientTypeSelected(current) {
     let selectedType = $(current).val();
     let s;
     for (i=0;i<ingredients.length;i++) {
         if (ingredients[i].ingredientType == selectedType) {
             s +=  '<option value="' + ingredients[i].name + '">'+ ingredients[i].name+ '</option>';
         }
     }
     $(current).closest('.form-row').find('.ingredientName').html(s);
   }