# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('alipay', '0004_auto_20150424_1513'),
    ]

    operations = [
        migrations.AddField(
            model_name='order',
            name='out_trade_no',
            field=models.TextField(default=''),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='order',
            name='trade_status',
            field=models.TextField(default=''),
            preserve_default=False,
        ),
    ]
