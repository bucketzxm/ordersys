# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Order',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('sign', models.TextField()),
                ('result', models.TextField()),
                ('out_trade_no', models.TextField()),
                ('trade_status', models.TextField()),
                ('request_token', models.TextField()),
            ],
        ),
    ]
