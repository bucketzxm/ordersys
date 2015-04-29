# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
#
# Also note: You'll have to insert the output of 'django-admin sqlcustom [app_label]'
# into your database.
from __future__ import unicode_literals

from django.db import models


class Agent(models.Model):
    agent_id = models.AutoField(primary_key=True)
    agent_money = models.DecimalField(max_digits=7, decimal_places=2, blank=True, null=True)
    agent_order = models.ForeignKey('Order', db_column='agent_order')
    agent_moneycopy = models.DecimalField(db_column='agent_moneyCopy', max_digits=7, decimal_places=2, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'agent'


class AuthGroup(models.Model):
    name = models.CharField(unique=True, max_length=80)

    class Meta:
        managed = False
        db_table = 'auth_group'


class AuthGroupPermissions(models.Model):
    group = models.ForeignKey(AuthGroup)
    permission = models.ForeignKey('AuthPermission')

    class Meta:
        managed = False
        db_table = 'auth_group_permissions'
        #unique_together = (('group_id', 'permission_id'),)


class AuthPermission(models.Model):
    name = models.CharField(max_length=255, blank=True, null=True)
    content_type = models.ForeignKey('DjangoContentType')
    codename = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'auth_permission'
        #unique_together = (('content_type_id', 'codename'),)


class AuthUser(models.Model):
    password = models.CharField(max_length=128)
    last_login = models.DateTimeField(blank=True, null=True)
    is_superuser = models.IntegerField()
    username = models.CharField(unique=True, max_length=30)
    first_name = models.CharField(max_length=30)
    last_name = models.CharField(max_length=30)
    email = models.CharField(max_length=254, blank=True, null=True)
    is_staff = models.IntegerField()
    is_active = models.IntegerField()
    date_joined = models.DateTimeField()

    class Meta:
        managed = False
        db_table = 'auth_user'


class AuthUserGroups(models.Model):
    user = models.ForeignKey(AuthUser)
    group = models.ForeignKey(AuthGroup)

    class Meta:
        managed = False
        db_table = 'auth_user_groups'
        #unique_together = (('user_id', 'group_id'),)


class AuthUserUserPermissions(models.Model):
    user = models.ForeignKey(AuthUser)
    permission = models.ForeignKey(AuthPermission)

    class Meta:
        managed = False
        db_table = 'auth_user_user_permissions'
        #unique_together = (('user_id', 'permission_id'),)


class Category(models.Model):
    category_id = models.AutoField(primary_key=True)
    category_name = models.CharField(max_length=40, blank=True, null=True)
    category_picture = models.CharField(max_length=45, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'category'
    def __str__(self):
        return self.category_name + " " + str(self.category_id)

    def __unicode__(self):
        return self.category_name + " " + str(self.category_id)


class Desk(models.Model):
    desk_num = models.IntegerField(primary_key=True)

    class Meta:
        managed = False
        db_table = 'desk'


class DjangoAdminLog(models.Model):
    action_time = models.DateTimeField()
    object_id = models.TextField(blank=True, null=True)
    object_repr = models.CharField(max_length=200)
    action_flag = models.SmallIntegerField()
    change_message = models.TextField()
    content_type = models.ForeignKey('DjangoContentType', blank=True, null=True)
    user = models.ForeignKey(AuthUser)

    class Meta:
        managed = False
        db_table = 'django_admin_log'


class DjangoContentType(models.Model):
    app_label = models.CharField(max_length=100)
    model = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'django_content_type'
        unique_together = (('app_label', 'model'),)


class DjangoMigrations(models.Model):
    app = models.CharField(max_length=255)
    name = models.CharField(max_length=255)
    applied = models.DateTimeField()

    class Meta:
        managed = False
        db_table = 'django_migrations'


class DjangoSession(models.Model):
    session_key = models.CharField(primary_key=True, max_length=40)
    session_data = models.TextField()
    expire_date = models.DateTimeField()

    class Meta:
        managed = False
        db_table = 'django_session'


class Evaluate(models.Model):
    dishid = models.ForeignKey('Food', db_column='dishId', blank=True, null=True)  # Field name made lowercase.
    score = models.IntegerField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'evaluate'


class Food(models.Model):
    food_id = models.AutoField(primary_key=True)
    food_score = models.DecimalField(max_digits=10, decimal_places=1, blank=True, null=True)
    food_name = models.CharField(max_length=40, blank=True, null=True)
    food_price = models.DecimalField(max_digits=7, decimal_places=2, blank=True, null=True)
    food_picture = models.CharField(max_length=40, blank=True, null=True)
    food_description = models.CharField(max_length=400, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'food'
    def __unicode__(self):
        return self.food_name+ " " + str(self.food_id)
    def __str__(self):
        return self.food_name + " " + str(self.food_id)



class Mac(models.Model):
    mac_id = models.AutoField(primary_key=True)
    mac_address = models.CharField(max_length=45, blank=True, null=True)
    mac_time = models.CharField(max_length=45, blank=True, null=True)
    mac_order = models.ForeignKey('Order', db_column='mac_order', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'mac'


class Menuitem(models.Model):
    menuitem_id = models.AutoField(primary_key=True)
    menuitem_bigsale = models.DecimalField(max_digits=7, decimal_places=2, blank=True, null=True)
    menuitem_status = models.IntegerField(blank=True, null=True)
    menuitem_food = models.ForeignKey(Food, db_column='menuitem_food', blank=True, null=True)
    menuitem_category = models.ForeignKey(Category, db_column='menuitem_category')

    class Meta:
        managed = False
        db_table = 'menuitem'

    def __unicode__(self):
        return self.menuitem_category.category_name + " - " + self.menuitem_food.food_name + " - " + str(self.menuitem_id)
    def __str__(self):
        return self.menuitem_category.category_name + " - " + self.menuitem_food.food_name + " - " + str(self.menuitem_id)


class Order(models.Model):
    order_id = models.AutoField(primary_key=True)
    order_code = models.CharField(max_length=40, blank=True, null=True)
    order_generatedate = models.CharField(max_length=50, blank=True, null=True)
    order_finishdate = models.CharField(max_length=50, blank=True, null=True)
    order_state = models.CharField(max_length=50, blank=True, null=True)
    order_mermoney = models.DecimalField(max_digits=7, decimal_places=2, blank=True, null=True)
    order_commoney = models.DecimalField(max_digits=7, decimal_places=2, blank=True, null=True)
    order_pay = models.ForeignKey('Pay', db_column='order_pay', blank=True, null=True)
    order_deskid = models.IntegerField(db_column='order_deskId', blank=True, null=True)  # Field name made lowercase.
    order_user = models.ForeignKey('User', db_column='order_user', blank=True, null=True)
    order_personnum = models.IntegerField(db_column='order_personNum', blank=True, null=True)  # Field name made lowercase.
    order_issent = models.TextField(db_column='order_isSent', blank=True, null=True)  # Field name made lowercase. This field type is a guess.
    order_iswaiterconfirm = models.TextField(db_column='order_isWaiterConfirm', blank=True, null=True)  # Field name made lowercase. This field type is a guess.
    order_ishumanpay = models.TextField(db_column='order_isHumanPay', blank=True, null=True)  # Field name made lowercase. This field type is a guess.
    out_trade_no = models.CharField(max_length=250, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'order'
    def __str__(self):
        if self.out_trade_no == None:
            return "order_id " + str( self.order_id )
        return "out_trade_no "+ self.out_trade_no
    def __unicode__(self):
        if self.out_trade_no == None:
            return "order_id " + str(self.order_id)
        return "out_trade_no "+ self.out_trade_no

class Orderitem(models.Model):
    orderitem_id = models.AutoField(primary_key=True)
    orderitem_status = models.IntegerField(blank=True, null=True)
    orderitem_amount = models.IntegerField(blank=True, null=True)
    orderitem_price = models.DecimalField(max_digits=7, decimal_places=2, blank=True, null=True)
    orderitem_owner = models.IntegerField(blank=True, null=True)
    orderitem_order = models.ForeignKey(Order, db_column='orderitem_order')
    orderitem_food = models.ForeignKey(Food, db_column='orderitem_food')

    class Meta:
        managed = False
        db_table = 'orderitem'


class Pay(models.Model):
    pay_id = models.AutoField(primary_key=True)
    pay_name = models.CharField(max_length=40, blank=True, null=True)
    pay_merchant = models.CharField(max_length=40, blank=True, null=True)
    pay_company = models.CharField(max_length=40, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'pay'


class Role(models.Model):
    role_id = models.AutoField(primary_key=True)
    role_name = models.CharField(max_length=40, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'role'


class ServerOrder(models.Model):
    sign = models.TextField()
    result = models.TextField()
    out_trade_no = models.TextField()
    trade_status = models.TextField()
    request_token = models.TextField()

    class Meta:
        managed = False
        db_table = 'server_order'


class Special(models.Model):
    special_id = models.AutoField(primary_key=True)
    special_price = models.DecimalField(max_digits=7, decimal_places=2, blank=True, null=True)
    special_remain = models.IntegerField(blank=True, null=True)
    special_quota = models.IntegerField(blank=True, null=True)
    special_food = models.ForeignKey(Food, db_column='special_food')
    special_picture = models.CharField(max_length=45, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'special'


class User(models.Model):
    user_id = models.AutoField(primary_key=True)
    user_name = models.CharField(max_length=40, blank=True, null=True)
    user_account = models.CharField(max_length=40, blank=True, null=True)
    user_passwd = models.CharField(max_length=40, blank=True, null=True)
    user_role = models.ForeignKey(Role, db_column='user_role', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'user'
