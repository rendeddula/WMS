   
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   
   
   <script>
	$( document ).ready(function() {
$('#cssmenu').prepend('<div id="menu-button">Menu</div>');
	$('#cssmenu #menu-button').on('click', function(){
		var menu = $(this).next('ul');
		if (menu.hasClass('open')) {
			menu.removeClass('open');
		}
		else {
			menu.addClass('open');
		}
	});
});
   
   </script>
   
   <title>CSS MenuMaker</title>
   <style>
   @import url(http://fonts.googleapis.com/css?family=PT+Sans:400,700);
#cssmenu {
  background: #4cb6ea;
  margin: 0;
  width: auto;
  padding: 0;
  line-height: 1;
  display: block;
  position: relative;
  font-family: 'PT Sans', sans-serif;
}
#cssmenu ul {
  list-style: none;
  margin: 0;
  padding: 0;
  display: block;
}
#cssmenu ul:after,
#cssmenu:after {
  content: " ";
  display: block;
  font-size: 0;
  height: 0;
  clear: both;
  visibility: hidden;
}
#cssmenu ul li {
  margin: 0;
  padding: 0;
  display: block;
  position: relative;
}
#cssmenu ul li a {
  text-decoration: none;
  display: block;
  margin: 0;
  -webkit-transition: color .2s ease;
  -moz-transition: color .2s ease;
  -ms-transition: color .2s ease;
  -o-transition: color .2s ease;
  transition: color .2s ease;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}
#cssmenu ul li ul {
  position: absolute;
  left: -9999px;
  top: auto;
}
#cssmenu ul li ul li {
  max-height: 0;
  position: absolute;
  -webkit-transition: max-height 0.4s ease-out;
  -moz-transition: max-height 0.4s ease-out;
  -ms-transition: max-height 0.4s ease-out;
  -o-transition: max-height 0.4s ease-out;
  transition: max-height 0.4s ease-out;
  background: #ffffff;
}
#cssmenu ul li ul li.has-sub:after {
  display: block;
  position: absolute;
  content: "";
  height: 10px;
  width: 10px;
  border-radius: 5px;
  background: #000000;
  z-index: 1;
  top: 13px;
  right: 15px;
}
#cssmenu.align-right ul li ul li.has-sub:after {
  right: auto;
  left: 15px;
}
#cssmenu ul li ul li.has-sub:before {
  display: block;
  position: absolute;
  content: "";
  height: 0;
  width: 0;
  border: 3px solid transparent;
  border-left-color: #ffffff;
  z-index: 2;
  top: 15px;
  right: 15px;
}
#cssmenu.align-right ul li ul li.has-sub:before {
  right: auto;
  left: 15px;
  border-left-color: transparent;
  border-right-color: #ffffff;
}
#cssmenu ul li ul li a {
  font-size: 14px;
  font-weight: 400;
  text-transform: none;
  color: #000000;
  letter-spacing: 0;
  display: block;
  width: 170px;
  padding: 11px 10px 11px 20px;
}
#cssmenu ul li ul li:hover > a,
#cssmenu ul li ul li.active > a {
  color: #4cb6ea;
}
#cssmenu ul li ul li:hover:after,
#cssmenu ul li ul li.active:after {
  background: #4cb6ea;
}
#cssmenu ul li ul li:hover > ul {
  left: 100%;
  top: 0;
}
#cssmenu ul li ul li:hover > ul > li {
  max-height: 72px;
  position: relative;
}
#cssmenu > ul > li {
  float: left;
}
#cssmenu.align-center > ul > li {
  float: none;
  display: inline-block;
}
#cssmenu.align-center > ul {
  text-align: center;
}
#cssmenu.align-center ul ul {
  text-align: left;
}
#cssmenu.align-right > ul {
  float: right;
}
#cssmenu.align-right > ul > li:hover > ul {
  left: auto;
  right: 0;
}
#cssmenu.align-right ul ul li:hover > ul {
  right: 100%;
  left: auto;
}
#cssmenu.align-right ul ul li a {
  text-align: right;
}
#cssmenu > ul > li:after {
  content: "";
  display: block;
  position: absolute;
  width: 100%;
  height: 0;
  top: 0;
  z-index: 0;
  background: #ffffff;
  -webkit-transition: height .2s;
  -moz-transition: height .2s;
  -ms-transition: height .2s;
  -o-transition: height .2s;
  transition: height .2s;
}
#cssmenu > ul > li.has-sub > a {
  padding-right: 40px;
}
#cssmenu > ul > li.has-sub > a:after {
  display: block;
  content: "";
  background: #ffffff;
  height: 12px;
  width: 12px;
  position: absolute;
  border-radius: 13px;
  right: 14px;
  top: 16px;
}
#cssmenu > ul > li.has-sub > a:before {
  display: block;
  content: "";
  border: 4px solid transparent;
  border-top-color: #4cb6ea;
  z-index: 2;
  height: 0;
  width: 0;
  position: absolute;
  right: 16px;
  top: 21px;
}
#cssmenu > ul > li > a {
  color: #ffffff;
  padding: 15px 20px;
  font-weight: 700;
  letter-spacing: 1px;
  text-transform: uppercase;
  font-size: 14px;
  z-index: 2;
  position: relative;
}
#cssmenu > ul > li:hover:after,
#cssmenu > ul > li.active:after {
  height: 100%;
}
#cssmenu > ul > li:hover > a,
#cssmenu > ul > li.active > a {
  color: #000000;
}
#cssmenu > ul > li:hover > a:after,
#cssmenu > ul > li.active > a:after {
  background: #000000;
}
#cssmenu > ul > li:hover > a:before,
#cssmenu > ul > li.active > a:before {
  border-top-color: #ffffff;
}
#cssmenu > ul > li:hover > ul {
  left: 0;
}
#cssmenu > ul > li:hover > ul > li {
  max-height: 72px;
  position: relative;
}
#cssmenu #menu-button {
  display: none;
}
#cssmenu > ul > li > a {
  display: block;
}
#cssmenu > ul > li {
  width: auto;
}
#cssmenu > ul > li > ul {
  width: 170px;
  display: block;
}
#cssmenu > ul > li > ul > li {
  width: 170px;
  display: block;
}
@media all and (max-width: 800px), only screen and (-webkit-min-device-pixel-ratio: 2) and (max-width: 1024px), only screen and (min--moz-device-pixel-ratio: 2) and (max-width: 1024px), only screen and (-o-min-device-pixel-ratio: 2/1) and (max-width: 1024px), only screen and (min-device-pixel-ratio: 2) and (max-width: 1024px), only screen and (min-resolution: 192dpi) and (max-width: 1024px), only screen and (min-resolution: 2dppx) and (max-width: 1024px) {
  #cssmenu > ul {
    max-height: 0;
    overflow: hidden;
    -webkit-transition: max-height 0.35s ease-out;
    -moz-transition: max-height 0.35s ease-out;
    -ms-transition: max-height 0.35s ease-out;
    -o-transition: max-height 0.35s ease-out;
    transition: max-height 0.35s ease-out;
  }
  #cssmenu > ul > li > ul {
    width: 100%;
    display: block;
  }
  #cssmenu.align-right ul li a {
    text-align: left;
  }
  #cssmenu > ul > li > ul > li {
    width: 100%;
    display: block;
  }
  #cssmenu.align-right ul ul li a {
    text-align: left;
  }
  #cssmenu > ul > li > ul > li > a {
    width: 100%;
    display: block;
  }
  #cssmenu ul li ul li a {
    width: 100%;
  }
  #cssmenu.align-center > ul {
    text-align: left;
  }
  #cssmenu.align-center > ul > li {
    display: block;
  }
  #cssmenu > ul.open {
    max-height: 1000px;
    border-top: 1px solid rgba(110, 110, 110, 0.25);
  }
  #cssmenu ul {
    width: 100%;
  }
  #cssmenu ul > li {
    float: none;
    width: 100%;
  }
  #cssmenu ul li a {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    width: 100%;
    padding: 12px 20px;
  }
  #cssmenu ul > li:after {
    display: none;
  }
  #cssmenu ul li.has-sub > a:after,
  #cssmenu ul li.has-sub > a:before,
  #cssmenu ul li ul li.has-sub:after,
  #cssmenu ul li ul li.has-sub:before {
    display: none;
  }
  #cssmenu ul li ul,
  #cssmenu ul li ul li ul,
  #cssmenu ul li ul li:hover > ul,
  #cssmenu.align-right ul li ul,
  #cssmenu.align-right ul li ul li ul,
  #cssmenu.align-right ul li ul li:hover > ul {
    left: 0;
    position: relative;
    right: auto;
  }
  #cssmenu ul li ul li,
  #cssmenu ul li:hover > ul > li {
    max-height: 999px;
    position: relative;
    background: none;
  }
  #cssmenu ul li ul li a {
    padding: 8px 20px 8px 35px;
    color: #ffffff;
  }
  #cssmenu ul li ul ul li a {
    padding: 8px 20px 8px 50px;
  }
  #cssmenu ul li ul li:hover > a {
    color: #000000;
  }
  #cssmenu #menu-button {
    display: block;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    width: 100%;
    padding: 15px 20px;
    text-transform: uppercase;
    font-weight: 700;
    font-size: 14px;
    letter-spacing: 1px;
    color: #ffffff;
    cursor: pointer;
  }
  #cssmenu #menu-button:after {
    display: block;
    content: '';
    position: absolute;
    height: 3px;
    width: 22px;
    border-top: 2px solid #ffffff;
    border-bottom: 2px solid #ffffff;
    right: 20px;
    top: 16px;
  }
  #cssmenu #menu-button:before {
    display: block;
    content: '';
    position: absolute;
    height: 3px;
    width: 22px;
    border-top: 2px solid #ffffff;
    right: 20px;
    top: 26px;
  }
}

   </style>
   


<div id='cssmenu'>
<ul>
   <li><a href='#'><span>Home</span></a></li>
 
   <li class='has-sub'><a href='#'><span>InBound</span></a>
   		<ul>
   		<li><a href="OrdersHeaderList"><span>Purchase Order</span></a></li>
   			<li><a href="Receive"><span>Receiving</span></a></li>
   			<li><a href="WMInventoryList"><span>WM Inventory</span></a></li>
   			
   			  <li class='last'><a href='#'><span>Put Away</span></a></li>
   		</ul>
   	
   </li>
   
   <li class='has-sub'><a href='#'><span>OutBound</span></a>
   		<ul>
   		<li><a href="SalesOrderList"><span>Sales Order</span></a></li>
   			
               <li><a href="Packing"><span>Packing</span></a></li>
                <li><a href='#'><span>Orders</span></a></li>
   		</ul>
   	
   </li>
   
   <li class='has-sub'><a href=''><span>Admin</span></a>
   		<ul>
   			<li><a href="itemslist"><span>Items</span></a></li>
   		</ul>
   	
   </li>
   <li class='last'><a href=""><span>Contact</span></a></li>
</ul>
</div>
