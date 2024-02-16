from django.shortcuts import render
from django.http import HttpResponse
from .forms import CreateNewMarketAd
# Create your views here.


def homepage(request):
    return render(request, 'homepage.html')

def say_hello(request):
    return render(request, 'hello.html', {'name': 'Sarah'})

def create_market_ad(request):
    if request.method == 'POST':
        form = CreateNewMarketAd(request.POST)
        if form.is_valid():
            x = form.cleaned_data['title']
            ad = CreateNewMarketAd()
            ad.save()
    else:
        form = CreateNewMarketAd()
    return render(request, 'create_market_ad.html', {'form': form})

