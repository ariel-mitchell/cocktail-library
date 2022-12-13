$(document).ready(function() {});
   function repeatFormElement(current){
    $(current).parents('.form-row').append($(current).parents('.form-row').clone());
   }

   function ingredientTypeSelected(current) {
     let selectedType = $(current).val();
     let s;
     for (i=0;i<ingredients.length;i++) {
         if (ingredients[i].ingredientType == selectedType) {
             s +=  '<option value="' + ingredients[i].id + '">'+ ingredients[i].name+ '</option>';
         }
     }
     $(current).closest('.form-row').find('.ingredientName').html(s);
   }