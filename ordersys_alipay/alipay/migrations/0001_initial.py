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
                ('buyer_email', models.TextField()),
                ('buyer_id', models.TextField()),
                ('exterface', models.TextField()),
                ('is_success', models.TextField()),
                ('notify_id', models.TextField()),
                ('notify_type', models.TextField()),
                ('out_trade_no', models.TextField()),
                ('payment_type', models.TextField()),
                ('seller_email', models.TextField()),
                ('seller_id', models.TextField()),
                ('subject', models.TextField()),
                ('total_fee', models.TextField()),
                ('trade_no', models.TextField()),
                ('trade_status', models.TextField()),
                ('sign', models.TextField()),
                ('sign_type', models.TextField()),
            ],
        ),
    ]
