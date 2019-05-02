<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Qui sommes-nous ?</h2>
  <p>Nous sommes trois jeunes cadres dynamiques, avides de richesse et passionnés d'informatique qui avons décidé de mettre nos compétences en communs pour faire du flouze.
  Alors comme le dirait Octave Parengo : achetez nos produits, sinon ils se vendront pas ! </p><br>
  <div class="image">
<!--     <div class="media-left media-top"> -->
<%--       <img src="${pageContext.request.contextPath }/img/jerem.png" class="media-object" style="width:80px"> --%>
<!--     </div> -->
<!--     <div class="media-body"> -->
<!--       <h4 class="media-heading">Jeremy Van Migem</h4> -->
<!--       <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p> -->
<!--       <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p> -->
<!--       <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p> -->
<!--     </div> -->
  </div>
  <div class="container">
  <div class="row">
  <h2>Circle</h2>
  <p>The .img-circle class shapes the image to a circle (not available in IE8):</p>
    <img src="webapp/Pages/resources/image/Joel.jpg">             
<!--   <img src="Joel.jpg" class="img-circle" alt="Joel" width="304" height="236">  -->
</div>
  <hr>
  <div class="media">
        <img src="webapp/Pages/resources/image/Joel.jpg">
    <div class="media-left media-middle">

    </div>
    <div class="media-body">
      <h4 class="media-heading">Joel Tourscher</h4>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
  </div>
  <hr>
  <div class="media">
    <div class="media-left media-bottom">
      <img src="webapp/Pages/resources/image/img_avatar1.png" class="media-object" style="width:80px">
    </div>
    <div class="media-body">
      <h4 class="media-heading">Nicolas Dach</h4>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </div>
  </div>
  <div class="container">
  <h2>Thumbnail</h2>
  <p>The .img-thumbnail class creates a thumbnail of the image:</p>            
  <img src="webaap/Pages/resources/image/jerem.png" class="img-thumbnail" alt="Cinque Terre" width="304" height="236"> 
</div>

<div class="container">
  <h2>Image Gallery</h2>
  <p>The .thumbnail class can be used to display an image gallery.</p>
  <p>The .caption class adds proper padding and a dark grey color to text inside thumbnails.</p>
  <p>Click on the images to enlarge them.</p>
  <div class="row">
    <div class="col-md-4">
      <div class="thumbnail">
          <img class="img-thumbnail" src="jerem.jpg" alt="Jeremy" style="width:100%">
          
          <div class="caption">
            <p>Lorem ipsum donec id elit non mi porta gravida at eget metus.</p>
          </div>
        
      </div>
    </div>
    
    <div class="gallery">
  <a target="_blank" href="jerem.png">
    <img src="jerem.png" alt="Forest" width="600" height="400">
  </a>
  <div class="desc">Add a description of the image here</div>
</div>
    
</div>

</body>
</html>
