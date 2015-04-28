# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('alipay', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='order',
            name='body',
            field=models.TextField(default=b''),
        ),
        migrations.AddField(
            model_name='order',
            name='notify_time',
            field=models.TextField(default=''),
            preserve_default=False,
        ),
    ]
