from django.urls import path
from . import views

#URL Config
urlpatterns = [
    path('hello/', views.say_hello),
    path('', views.homepage),
    path('create_market_ad/', views.create_market_ad)
]