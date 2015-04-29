# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('my_admin', '0003_auto_20150426_0953'),
    ]

    operations = [
        migrations.CreateModel(
            name='DjangoSession',
            fields=[
                ('session_key', models.CharField(max_length=40, serialize=False, primary_key=True)),
                ('session_data', models.TextField()),
                ('expire_date', models.DateTimeField()),
            ],
            options={
                'db_table': 'django_session',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='ServerOrder',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('sign', models.TextField()),
                ('result', models.TextField()),
                ('out_trade_no', models.TextField()),
                ('trade_status', models.TextField()),
                ('request_token', models.TextField()),
            ],
            options={
                'db_table': 'server_order',
                'managed': False,
            },
        ),
    ]
