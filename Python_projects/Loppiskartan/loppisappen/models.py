import datetime
from django.db import models

# Create your models here.


class MarketAd(models.Model):
    id = models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')
    datetime = models.DateTimeField(default=datetime.datetime.today())
    title = models.CharField(max_length=120)
    desc = models.CharField(max_length=470)
    location = models.CharField(max_length=255)
    category = models.CharField(max_length=120)
    user_id = models.CharField(max_length=12)

    def __str__(self):
        return self.title


class User(models.Model):
    id = models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')
    username = models.CharField(max_length=120)
    user_first_name = models.CharField(max_length=155)
    user_last_name = models.CharField(max_length=155)
    market_ad = models.ForeignKey(MarketAd, on_delete=models.CASCADE, null= True)

    def __str__(self):
        return self.username


