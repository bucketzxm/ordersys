# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('alipay', '0002_auto_20150424_0636'),
    ]

    operations = [
        migrations.RenameField(
            model_name='order',
            old_name='buyer_email',
            new_name='notify_data',
        ),
        migrations.RenameField(
            model_name='order',
            old_name='buyer_id',
            new_name='sec_id',
        ),
        migrations.RenameField(
            model_name='order',
            old_name='exterface',
            new_name='service',
        ),
        migrations.RenameField(
            model_name='order',
            old_name='is_success',
            new_name='v',
        ),
        migrations.RemoveField(
            model_name='order',
            name='body',
        ),
        migrations.RemoveField(
            model_name='order',
            name='notify_id',
        ),
        migrations.RemoveField(
            model_name='order',
            name='notify_time',
        ),
        migrations.RemoveField(
            model_name='order',
            name='notify_type',
        ),
        migrations.RemoveField(
            model_name='order',
            name='out_trade_no',
        ),
        migrations.RemoveField(
            model_name='order',
            name='payment_type',
        ),
        migrations.RemoveField(
            model_name='order',
            name='seller_email',
        ),
        migrations.RemoveField(
            model_name='order',
            name='seller_id',
        ),
        migrations.RemoveField(
            model_name='order',
            name='sign_type',
        ),
        migrations.RemoveField(
            model_name='order',
            name='subject',
        ),
        migrations.RemoveField(
            model_name='order',
            name='total_fee',
        ),
        migrations.RemoveField(
            model_name='order',
            name='trade_no',
        ),
        migrations.RemoveField(
            model_name='order',
            name='trade_status',
        ),
    ]
