<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Navigation</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=2">
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
}

body {
	background: url('/img/windmill.jpg') no-repeat right bottom fixed;
	background-size: cover;
}

a:link, a:visited {
	color: #fff;
	text-decoration: none;
	text-shadow: 1px 1px 0 #283744;
}

a:hover {
	color: lime;
	text-decoration: underline;
	text-shadow: 1px 1px 0 #283744;
}

nav {
	width: 100%;
	height: auto;
	background: #34495e;
	font-size: 1.2em;
	font-weight: bold;
	position: relative;
}

nav ul {
	display: none;
	height: auto;
}

nav ul li {
	display: block;
	width: 100%;
	border-bottom: 1px solid #576979;
}

nav ul li a {
	line-height: 50px;
}

nav a#trigger {
	display: block;
	background-color: orange;
	width: 100%;
	padding-left: 15px;
	line-height: 40px;
	position: relative;
}

nav a#trigger::after {
	content: "";
	background: url('/img/nav.png') no-repeat;
	width: 30px;
	height: 30px;
	display: inline-block;
	position: absolute;
	right: 15px;
	top: 10px;
}

@media screen and (min-width:721px) {
	nav {
		height: 40px;
		border-bottom: 2px solid gray;
	}
	nav ul {
		display: block;
		width: 720px;
		height: 40px;
		padding: 0;
		margin: 0 auto;
		text-align: center;
	}
	nav ul li {
		display: inline-block;
		width: 120px;
		border-bottom: 0;
		border-right: 1px solid #576979;
		margin-right: -6px;
	}
	nav ul li:last-child {
		border-right: 0;
	}
	nav ul li a {
		font-size: 1em;
		line-height: 40px;
	}
	nav a#trigger {
		display: block;
	}
}
</style>
</head>
<body>
	<nav>
		<ul>
			<li><a href="#">HOME</a></li>
			<li><a href="#">ABOUT</a></li>
			<li><a href="#">WEB</a></li>
			<li><a href="#">DESIGN</a></li>
			<li><a href="#">MAP</a></li>
			<li><a href="#">CONTACT</a></li>
		</ul>
		<a href="#" id="trigger">MENU</a>
	</nav>

	<script src="/js/doit/jquery-2.2.4.min.js"></script>
	<script>
		$(function() {
			var trigger = $('#trigger');
			var menu = $('nav ul');
			$(trigger).on('click', function(e) {
				e.preventDefault();
				menu.slideToggle();
			});
			$(window).resize(function() {
				var w = $(window).width();
				if (w > 320 && menu.is(':hidden')) {
					menu.removeAttr('style');
				}
			});
		});
	</script>
</body>
</html>