# Generated by Django 5.0.1 on 2024-01-23 14:22

import django.db.models.deletion
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('loppisappen', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='user',
            name='market_ad',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, to='loppisappen.market_ad'),
        ),
    ]