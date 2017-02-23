<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="simplify_if_kindof"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="typ"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="ExprTyping"/>
		<constant value="TYP"/>
		<constant value="J.allInstances():J"/>
		<constant value="J.first():J"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="10:37-10:51"/>
		<constant value="10:37-10:66"/>
		<constant value="10:37-10:75"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchremoveIf():V"/>
		<constant value="__exec__"/>
		<constant value="removeIf"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyremoveIf(NTransientLink;):V"/>
		<constant value="isKindOf"/>
		<constant value="MOCL!OclExpression;"/>
		<constant value="12:62-12:67"/>
		<constant value="MOCL!OperationCallExp;"/>
		<constant value="0"/>
		<constant value="oclIsKindOf"/>
		<constant value="J.=(J):J"/>
		<constant value="7"/>
		<constant value="source"/>
		<constant value="arguments"/>
		<constant value="J.isSameType(JJ):J"/>
		<constant value="16:5-16:9"/>
		<constant value="16:5-16:14"/>
		<constant value="16:17-16:30"/>
		<constant value="16:5-16:30"/>
		<constant value="19:3-19:8"/>
		<constant value="17:3-17:13"/>
		<constant value="17:3-17:17"/>
		<constant value="17:29-17:33"/>
		<constant value="17:29-17:40"/>
		<constant value="17:42-17:46"/>
		<constant value="17:42-17:56"/>
		<constant value="17:42-17:65"/>
		<constant value="17:3-17:66"/>
		<constant value="16:2-20:7"/>
		<constant value="__matchremoveIf"/>
		<constant value="IfExp"/>
		<constant value="OCL"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="condition"/>
		<constant value="J.isKindOf():J"/>
		<constant value="B.not():B"/>
		<constant value="32"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="o"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="a"/>
		<constant value="Replace"/>
		<constant value="ACT"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="24:3-24:4"/>
		<constant value="24:3-24:14"/>
		<constant value="24:3-24:25"/>
		<constant value="26:5-26:20"/>
		<constant value="__applyremoveIf"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="thenExpression"/>
		<constant value="target"/>
		<constant value="28:3-28:4"/>
		<constant value="28:15-28:16"/>
		<constant value="28:3-28:17"/>
		<constant value="29:3-29:4"/>
		<constant value="29:15-29:16"/>
		<constant value="29:15-29:31"/>
		<constant value="29:3-29:32"/>
		<constant value="27:2-30:3"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<field name="5" type="4"/>
	<operation name="6">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="8"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="10"/>
			<pcall arg="11"/>
			<dup/>
			<push arg="12"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="13"/>
			<pcall arg="11"/>
			<pcall arg="14"/>
			<set arg="3"/>
			<getasm/>
			<push arg="15"/>
			<push arg="16"/>
			<findme/>
			<call arg="17"/>
			<call arg="18"/>
			<set arg="5"/>
			<getasm/>
			<push arg="19"/>
			<push arg="9"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="20"/>
			<getasm/>
			<pcall arg="21"/>
		</code>
		<linenumbertable>
			<lne id="22" begin="17" end="19"/>
			<lne id="23" begin="17" end="20"/>
			<lne id="24" begin="17" end="21"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="25" begin="0" end="31"/>
		</localvariabletable>
	</operation>
	<operation name="26">
		<context type="7"/>
		<parameters>
			<parameter name="27" type="4"/>
		</parameters>
		<code>
			<load arg="27"/>
			<getasm/>
			<get arg="3"/>
			<call arg="28"/>
			<if arg="29"/>
			<getasm/>
			<get arg="1"/>
			<load arg="27"/>
			<call arg="30"/>
			<dup/>
			<call arg="31"/>
			<if arg="32"/>
			<load arg="27"/>
			<call arg="33"/>
			<goto arg="34"/>
			<pop/>
			<load arg="27"/>
			<goto arg="35"/>
			<push arg="36"/>
			<push arg="9"/>
			<new/>
			<load arg="27"/>
			<iterate/>
			<store arg="37"/>
			<getasm/>
			<load arg="37"/>
			<call arg="38"/>
			<call arg="39"/>
			<enditerate/>
			<call arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="41" begin="23" end="27"/>
			<lve slot="0" name="25" begin="0" end="29"/>
			<lve slot="1" name="42" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="43">
		<context type="7"/>
		<parameters>
			<parameter name="27" type="4"/>
			<parameter name="37" type="44"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="27"/>
			<call arg="30"/>
			<load arg="27"/>
			<load arg="37"/>
			<call arg="45"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="25" begin="0" end="6"/>
			<lve slot="1" name="42" begin="0" end="6"/>
			<lve slot="2" name="46" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="47">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="48"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="25" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="49">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="50"/>
			<call arg="51"/>
			<iterate/>
			<store arg="27"/>
			<getasm/>
			<load arg="27"/>
			<pcall arg="52"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="41" begin="5" end="8"/>
			<lve slot="0" name="25" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="53">
		<context type="54"/>
		<parameters>
		</parameters>
		<code>
			<pushf/>
		</code>
		<linenumbertable>
			<lne id="55" begin="0" end="0"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="25" begin="0" end="0"/>
		</localvariabletable>
	</operation>
	<operation name="53">
		<context type="56"/>
		<parameters>
		</parameters>
		<code>
			<load arg="57"/>
			<get arg="46"/>
			<push arg="58"/>
			<call arg="59"/>
			<if arg="60"/>
			<pushf/>
			<goto arg="32"/>
			<getasm/>
			<get arg="5"/>
			<load arg="57"/>
			<get arg="61"/>
			<load arg="57"/>
			<get arg="62"/>
			<call arg="18"/>
			<call arg="63"/>
		</code>
		<linenumbertable>
			<lne id="64" begin="0" end="0"/>
			<lne id="65" begin="0" end="1"/>
			<lne id="66" begin="2" end="2"/>
			<lne id="67" begin="0" end="3"/>
			<lne id="68" begin="5" end="5"/>
			<lne id="69" begin="7" end="7"/>
			<lne id="70" begin="7" end="8"/>
			<lne id="71" begin="9" end="9"/>
			<lne id="72" begin="9" end="10"/>
			<lne id="73" begin="11" end="11"/>
			<lne id="74" begin="11" end="12"/>
			<lne id="75" begin="11" end="13"/>
			<lne id="76" begin="7" end="14"/>
			<lne id="77" begin="0" end="14"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="25" begin="0" end="14"/>
		</localvariabletable>
	</operation>
	<operation name="78">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
			<push arg="79"/>
			<push arg="80"/>
			<findme/>
			<push arg="81"/>
			<call arg="82"/>
			<iterate/>
			<store arg="27"/>
			<load arg="27"/>
			<get arg="83"/>
			<call arg="84"/>
			<call arg="85"/>
			<if arg="86"/>
			<getasm/>
			<get arg="1"/>
			<push arg="87"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="50"/>
			<pcall arg="88"/>
			<dup/>
			<push arg="89"/>
			<load arg="27"/>
			<pcall arg="90"/>
			<dup/>
			<push arg="91"/>
			<push arg="92"/>
			<push arg="93"/>
			<new/>
			<pcall arg="94"/>
			<pusht/>
			<pcall arg="95"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="96" begin="7" end="7"/>
			<lne id="97" begin="7" end="8"/>
			<lne id="98" begin="7" end="9"/>
			<lne id="99" begin="24" end="29"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="89" begin="6" end="31"/>
			<lve slot="0" name="25" begin="0" end="32"/>
		</localvariabletable>
	</operation>
	<operation name="100">
		<context type="7"/>
		<parameters>
			<parameter name="27" type="101"/>
		</parameters>
		<code>
			<load arg="27"/>
			<push arg="89"/>
			<call arg="102"/>
			<store arg="37"/>
			<load arg="27"/>
			<push arg="91"/>
			<call arg="103"/>
			<store arg="104"/>
			<load arg="104"/>
			<pop/>
			<load arg="104"/>
			<load arg="37"/>
			<set arg="61"/>
			<load arg="104"/>
			<load arg="37"/>
			<get arg="105"/>
			<set arg="106"/>
		</code>
		<linenumbertable>
			<lne id="99" begin="8" end="9"/>
			<lne id="107" begin="10" end="10"/>
			<lne id="108" begin="11" end="11"/>
			<lne id="109" begin="10" end="12"/>
			<lne id="110" begin="13" end="13"/>
			<lne id="111" begin="14" end="14"/>
			<lne id="112" begin="14" end="15"/>
			<lne id="113" begin="13" end="16"/>
			<lne id="114" begin="10" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="91" begin="7" end="16"/>
			<lve slot="2" name="89" begin="3" end="16"/>
			<lve slot="0" name="25" begin="0" end="16"/>
			<lve slot="1" name="115" begin="0" end="16"/>
		</localvariabletable>
	</operation>
</asm>
