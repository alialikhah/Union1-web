			$(document).ready(function(){
				$('#btnHide').click(function(){
					$('p').hide(1000)
				})
				
				$('#btnShow').click(function(){
					$('p').show(1000)
				})
				
				$('#btnToggle').click(function(){
					$('p').toggle(1000)
				})
				
				$('#btnFadeOut').click(function(){
					$('p').fadeOut(1000)
				})
				
				$('#btnFadeIn').click(function(){
					$('p').fadeIn(1000)
				})
				
				$('#btnFadeToggle').click(function(){
					$('#munX').fadeToggle(1000)
				})
				
				$('#btnFadeTo').click(function(){
					$('p').fadeTo(200 , 0.2)
				})
				
				$('#btnSlideUp').click(function(){
					$('p').slideUp(1000)
				})
				
				$('#btnSlideDown').click(function(){
					$('p').slideDown(1000)
				})
				
				$('#btnSlideToggle').click(function(){
					$('p').slideToggle(1000)
				})
				
				$('#btnAnimate').click(function(){
					$('#p1').animate({'width':'200px' , 'height' : '600px' , 'display':'block' } , 500)

				
				})
				
				$('#btnStop').click(function(){
					$('#p1').stop(true , true);
				})
			})
