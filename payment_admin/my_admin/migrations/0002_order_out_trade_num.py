# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('my_admin', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='order',
            name='out_trade_num',
            field=models.CharField(max_length=250, null=True, blank=True),
        ),
    ]
